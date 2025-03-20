import React, { useState, useEffect } from "react";
import {
  Layout,
  Menu,
  Input,
  Button,
  Typography,
  message,
  Modal,
  Form,
} from "antd";
import {
  SearchOutlined,
  ExclamationCircleOutlined,
  UserAddOutlined,
} from "@ant-design/icons";
import UserCard from "../../shared/component/userCard";

import { deleteUser, getUser, updateUser, createUser } from "./api";

import { useNavigate } from "react-router-dom";

const { Sider, Content } = Layout;
const { Title } = Typography;
const { confirm } = Modal;

const User = () => {
  const [selectedUser, setSelectedUser] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [users, setUsers] = useState([]);
  const [form] = Form.useForm();
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [errorModalVisible, setErrorModalVisible] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    getUser()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.log(error);
        navigate("/notAuth");
      });
  }, []);

  useEffect(() => {
    if (selectedUser) {
      form.setFieldsValue({
        name: selectedUser.name,
        surname: selectedUser.surname,
        email: selectedUser.email,
        departmant: selectedUser.departmant,
        username: selectedUser.username,
      });
    }
  }, [selectedUser, form]);

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const filteredUsers = users.filter((user) =>
    `${user.name} ${user.surname}`
      .toLowerCase()
      .includes(searchTerm.toLowerCase())
  );

  const handleUserClick = (user) => {
    setSelectedUser(user);
  };

  const createNewUser = async (values) => {
    // Create new user
    try {
      const createUserData = {
        name: values.name,
        surname: values.surname,
        email: values.email,
        departmant: values.departmant,
        username: values.username,
        password: values.password,
      };
      // Yeni kullanıcıyı API'ye gönder
      await createUser(createUserData);
      values.message // Başarı mesajı
        .success("User created successfully!");
      // Modal'ı kapat
      getUser()
        .then((response) => {
          setUsers(response.data);
        })
        .catch((error) => {
          setErrorMessage(String(error.response?.data));
          navigate("/notAuth");
        });
      setIsModalVisible(false);
      // UI'da güncelleme yapmak için setUsers kullanarak listeyi güncelle
    } catch (error) {
      setErrorMessage(String(error.response?.data));
      setErrorModalVisible(true);
    }
  };
  const updatedUser = async (values) => {
    if (selectedUser) {
      // Edit user
      try {
        const updatedUserData = {
          id: selectedUser.id,
          name: values.name,
          surname: values.surname,
          email: values.email,
          departmant: values.departmant,
          username: values.username,
        };

        if (values.password) {
          updatedUserData.password = values.password;
        }

        await updateUser(Number(selectedUser.id), updatedUserData);

        const updatedUsers = users.map((user) =>
          user.id === selectedUser.id ? { ...user, ...updatedUserData } : user
        );
        setUsers(updatedUsers);
        setSelectedUser({ ...selectedUser, ...updatedUserData });

        message.success("User updated successfully!");
        form.setFieldsValue({
          password: "",
        });

        setIsModalVisible(false);
      } catch (error) {
        console.error("Error updating user:", error);
        setErrorMessage(error.response?.data.password);
        setErrorModalVisible(true);
      }
    }
  };

  const handleDelete = () => {
    confirm({
      title: "Are you sure you want to delete this user?",
      icon: <ExclamationCircleOutlined />,
      content: "This action cannot be undone.",
      onOk() {
        deleteUser(selectedUser.id)
          .then(() => {
            // Kullanıcı başarıyla silindi, listeyi güncelle
            setUsers((prevUsers) => {
              // Kullanıcıyı filtreleyip silinmiş kullanıcıyı çıkarıyoruz
              const updatedUsers = prevUsers.filter(
                (user) => user.id !== selectedUser.id
              );
              return updatedUsers; // Güncellenmiş listeyi döndürüyoruz
            });

            // Seçilen kullanıcıyı sıfırla
            setSelectedUser(null);

            message.success("User deleted successfully!");
          })
          .catch((error) => {
            console.error("Error deleting user:", error);
            message.error("Failed to delete user.");
          });
      },
    });
  };

  const handleOpenModal = () => {
    setSelectedUser(null);
    form.resetFields();
    setIsModalVisible(true);
  };

  const handleCancelModal = () => {
    setIsModalVisible(false);
    form.resetFields();
  };

  const handleErrorModalClose = () => {
    setErrorModalVisible(false);
  };

  return (
    <Layout style={{ minHeight: "100vh", overflow: "hidden" }}>
      <Sider
        width={250}
        style={{
          background: "#fff",
          padding: "20px",
          height: "100vh",
          overflow: "hidden",
        }}
      >
        <Button
          type="primary"
          style={{
            marginBottom: 20,
            backgroundColor: "green",
            borderColor: "green",
            width: "200px",
          }}
          onClick={handleOpenModal}
          icon={<UserAddOutlined />}
        >
          Add User
        </Button>
        <Input
          placeholder="Search by Name or Surname"
          prefix={<SearchOutlined />}
          value={searchTerm}
          onChange={handleSearchChange}
          style={{ marginBottom: 20 }}
        />
        <Menu
          mode="inline"
          style={{ height: "100%", borderRight: 0, overflowY: "hidden" }}
        >
          {filteredUsers.map((user) => (
            <Menu.Item key={user.id} onClick={() => handleUserClick(user)}>
              {user.name} {user.surname}
            </Menu.Item>
          ))}
        </Menu>
      </Sider>

      <Layout style={{ flex: 1, padding: "0 24px", overflow: "hidden" }}>
        <Content style={{ display: "flex" }}>
          {selectedUser ? (
            <UserCard
              form={form}
              onFinish={updatedUser}
              selectedUser={selectedUser}
              isEditMode={true}
              handleDelete={handleDelete}
            />
          ) : (
            <Title></Title>
          )}
        </Content>
      </Layout>

      {/* Add User Modal */}
      <Modal
        title="Add User"
        open={isModalVisible}
        onCancel={handleCancelModal}
        footer={null}
        width="800px"
        destroyOnClose
      >
        <UserCard
          form={null}
          onFinish={createNewUser}
          selectedUser={null}
          isEditMode={false}
          handleDelete={null}
        />
      </Modal>

      {/* Error Modal */}
      <Modal
        title="Error"
        open={errorModalVisible}
        onCancel={handleErrorModalClose}
        footer={[
          <Button key="close" onClick={handleErrorModalClose}>
            Close
          </Button>,
        ]}
      >
        <p>{errorMessage}</p>
      </Modal>
    </Layout>
  );
};

export default User;
