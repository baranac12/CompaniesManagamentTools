import React, { useState, useEffect } from "react";
import { Form, Input, InputNumber, Popconfirm, Table, Typography } from "antd";
import axios from "axios"; // API istekleri için axios kullanalım
import { deleteUser, getUser, updateUser, createUser } from "../user/api";

const EditableCell = ({
  editing,
  dataIndex,
  title,
  inputType,
  record,
  index,
  children,
  ...restProps
}) => {
  const inputNode = inputType === "number" ? <InputNumber /> : <Input />;
  return (
    <td {...restProps}>
      {editing ? (
        <Form.Item
          name={dataIndex}
          style={{
            margin: 0,
          }}
          rules={[
            {
              required: true,
              message: `Please Input ${title}!`,
            },
          ]}
        >
          {inputNode}
        </Form.Item>
      ) : (
        children
      )}
    </td>
  );
};

const App = () => {
  const [form] = Form.useForm();
  const [data, setData] = useState([]);
  const [columns, setColumns] = useState([]);
  const [editingKey, setEditingKey] = useState("");
  const isEditing = (record) => record.key === editingKey;

  useEffect(() => {
    // API'den veri alıyoruz (getUser fonksiyonunu burada çağırıyoruz)
    getUser() // API endpoint
      .then((response) => {
        const fetchedData = response.data;
        if (fetchedData.length > 0) {
          // Dinamik kolonları oluşturma
          const dynamicColumns = Object.keys(fetchedData[0]).map((key) => ({
            title: key.charAt(0).toUpperCase() + key.slice(1), // Kolon başlığını belirliyoruz
            dataIndex: key,
            key, // Kolon adını key olarak kullanıyoruz
            editable: true, // Tüm kolonlar editable olacak şekilde ayarlandı
          }));

          setColumns(dynamicColumns); // Dinamik kolonları set ediyoruz
          const dataWithKey = fetchedData.map((item, index) => ({
            ...item,
            key: index.toString(), // Her veri satırına benzersiz bir 'key' ekliyoruz
          }));
          setData(dataWithKey); // Veriyi set ediyoruz
        }
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const edit = (record) => {
    form.setFieldsValue({
      ...record,
    });
    setEditingKey(record.key);
  };

  const cancel = () => {
    setEditingKey("");
  };

  const save = async (key) => {
    try {
      const row = await form.validateFields();
      const newData = [...data];
      const index = newData.findIndex((item) => key === item.key);
      if (index > -1) {
        const item = newData[index];
        newData.splice(index, 1, {
          ...item,
          ...row,
        });
        setData(newData);
        setEditingKey("");

        // Güncelleme isteğini göndermek için id'yi kullanıyoruz
        const updatedItem = newData[index];
        const id = updatedItem.id; // id değerini alıyoruz
        // PUT isteği ile veriyi güncelliyoruz
        //await axios.put(`/v1/user/${id}`, updatedItem);
        updateUser(id, updatedItem);
      }
    } catch (errInfo) {
      console.log("Validate Failed:", errInfo);
    }
  };

  const columnsWithEdit = columns.map((col) => ({
    ...col,
    onCell: (record) => ({
      record,
      inputType: col.dataIndex === "age" ? "number" : "text", // 'age' kolonu için sayı tipi
      dataIndex: col.dataIndex,
      title: col.title,
      editing: isEditing(record),
    }),
  }));

  const columnsWithOperation = [
    {
      title: "Operation",
      dataIndex: "Operation",
      render: (_, record) => {
        const editable = isEditing(record);
        return editable ? (
          <span>
            <Typography.Link
              onClick={() => save(record.key)}
              style={{
                marginInlineEnd: 8,
              }}
            >
              Save
            </Typography.Link>
            <Popconfirm title="Sure to cancel?" onConfirm={cancel}>
              <a>Cancel</a>
            </Popconfirm>
          </span>
        ) : (
          <Typography.Link
            disabled={editingKey !== ""}
            onClick={() => edit(record)}
          >
            Edit
          </Typography.Link>
        );
      },
    },
  ];

  return (
    <Form form={form} component={false}>
      <Table
        components={{
          body: {
            cell: EditableCell,
          },
        }}
        bordered
        dataSource={data}
        columns={[...columnsWithEdit, ...columnsWithOperation]} // Kolonları birleştiriyoruz
        rowClassName="editable-row"
        pagination={{
          onChange: cancel,
        }}
      />
    </Form>
  );
};

export default App;
