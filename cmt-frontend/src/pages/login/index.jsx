import React, { useEffect, useState } from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Alert, Button, Spin, Form, Input, Layout, Image } from 'antd';
import { loginUser } from './api.js';
import { useNavigate } from 'react-router-dom';
import bgImage from '../../assets/homeBG.png';
import logo from '../../assets/logo.png'

export function Login() {
  // Initialize state with empty strings
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const [apiProgress, setApiProgress] = useState(false);
  const [successMessage, setSuccessMessage] = useState();
  const [errorMessage, setErrorMessage] = useState();

  const navigate = useNavigate();

  const onSubmit = async (event) => {
    setApiProgress(true)
    setErrorMessage();
    try {
      await loginUser({
        username,
        password
      })
      navigate('/dashboard')
    } catch (error) {
      console.log(error.response.data)
      setErrorMessage(error.response.data.message)
    } finally {
      setApiProgress(false)

    }
  }


  const onChangeUsername = (e) => {
    setUsername(e.target.value);
  };
  const onChangePassword = (e) => {
    setPassword(e.target.value);
  };

  const divStyle = {
    margin: 'auto',
    padding: '5vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column',
    background: "rgba(255,255,255,0.9)",
    borderRadius: '8px', // Default border radius
  }

  const layoutStyle = {
    backgroundImage: `url(${bgImage})`,
    backgroundSize: '100% 100%',
    minHeight: '100vh',
  }

  return (
    <Layout style={layoutStyle}>
      <div style={divStyle}>
        <Image
          width={300}
          src={logo}
          style={{
            width: '100%',
          }}
        />
        <Form
          name="login"
          initialValues={{
            remember: true,
          }}
          onFinish={onSubmit} // Handle form submission
        >
          <Form.Item
            name="username"
            rules={[
              {
                required: true,
                message: 'Kullanıcı Adı Boş olamaz',
              },
            ]}
          >
            <Input
              prefix={<UserOutlined />}
              onChange={onChangeUsername}
              placeholder="Kullanıcı Adı"
            />
          </Form.Item>
          <Form.Item
            name="password"
            rules={[
              {
                required: true,
                message: 'Şifre Boş Olamaz',
              },
            ]}
          >
            <Input
              prefix={<LockOutlined />}
              type="password"
              onChange={onChangePassword}
              placeholder="Şifre"
            />
          </Form.Item>

          {successMessage && <Alert
            message={successMessage}
            type="success"
            showIcon
          />}

          {errorMessage && <Alert message={errorMessage} type="error" showIcon />}
          <Form.Item style={{ marginTop: '3vh' }}>
            <Button block color="primary" variant="outlined" htmlType="submit">
              Log in {apiProgress && <Spin size='small' />}
            </Button>
          </Form.Item>
        </Form>

      </div>
    </Layout>
  );
}
