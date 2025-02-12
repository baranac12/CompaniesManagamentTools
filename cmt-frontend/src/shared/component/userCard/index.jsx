import React, { useEffect, useState } from "react";
import { Card, Form, Input, Button, Row, Col } from "antd";

const UserCard = ({ form, onFinish, isEditMode, selectedUser, handleDelete }) => {
    // Başlık için state oluşturuluyor
    const [cardTitle, setCardTitle] = useState("");

    useEffect(() => {
        // selectedUser değiştiğinde başlık güncellenir
        if (selectedUser) {
            setCardTitle(`${selectedUser.name} ${selectedUser.surname}`);
        } else {
            setCardTitle("Add New User");

        }
    }, [selectedUser]);

    return (
        <Card
            title={cardTitle} // Başlık dinamik olarak buradan alınıyor
            bordered={false}
            style={{
                width: "100%",
                textAlign: "center",
                marginTop: "20px",
                padding: "20px",
                boxShadow: "0 2px 8px rgba(0, 0, 0, 0.15)",
            }}
        >
            <Form
                form={form}
                onFinish={(values) => {
                    onFinish(values);
                }}
                initialValues={{
                    name: selectedUser?.name || '',
                    surname: selectedUser?.surname || '',
                    email: selectedUser?.email || '',
                    departmant: selectedUser?.departmant || '',
                    username: selectedUser?.username || '',
                }}
                layout="vertical"
            >
                {/* Name and Surname Row */}
                <Row gutter={24}>
                    <Col span={12}>
                        <Form.Item
                            label="Name"
                            name="name"
                            rules={[{ required: true, message: "Please input your name!" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    <Col span={12}>
                        <Form.Item
                            label="Surname"
                            name="surname"
                            rules={[{ required: true, message: "Please input your surname!" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                </Row>

                {/* Email and Department Row */}
                <Row gutter={24}>
                    <Col span={12}>
                        <Form.Item
                            label="Email"
                            name="email"
                            rules={[{ required: true, type: "email", message: "Please input a valid email!" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    <Col span={12}>
                        <Form.Item label="Department" name="departmant">
                            <Input />
                        </Form.Item>
                    </Col>
                </Row>

                {/* Username and Password Row */}
                <Row gutter={24}>
                    <Col span={12}>
                        <Form.Item
                            label="Username"
                            name="username"
                            rules={[{ required: true, message: "Please input your username!" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    <Col span={12}>
                        {/* Şifre alanları opsiyonel hale getirildi */}
                        <Form.Item label="Password" name="password">
                            <Input.Password placeholder="Leave blank to keep current password" />
                        </Form.Item>
                        <Form.Item
                            label="Repeat Password"
                            name="passwordRepeat"
                            dependencies={["password"]}
                            rules={[
                                ({ getFieldValue }) => ({
                                    validator(_, value) {
                                        if (!value || getFieldValue("password") === value) {
                                            return Promise.resolve();
                                        }
                                        return Promise.reject("Passwords do not match!");
                                    },
                                }),
                            ]}
                        >
                            <Input.Password />
                        </Form.Item>
                    </Col>
                </Row>

                {/* Action Buttons */}
                <Row gutter={16}>
                    <Col span={24} style={{ textAlign: "center" }}>
                        <Button type="primary" htmlType="submit" style={{ marginRight: 10 }}>
                            {isEditMode ? "Update" : "Add User"}
                        </Button>
                        {isEditMode && (
                            <Button type="primary" danger onClick={handleDelete}>
                                Delete
                            </Button>
                        )}
                    </Col>
                </Row>
            </Form>
        </Card>
    );
};

export default UserCard;
