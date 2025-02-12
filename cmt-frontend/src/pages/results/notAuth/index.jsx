import React from 'react';
import { Button, Result } from 'antd';
import { useNavigate } from 'react-router-dom';
const App = () => {
    // useNavigate'ı burada, bileşenin içinde kullanmalısınız
    const navigate = useNavigate();

    // onClick fonksiyonu
    const onClick = () => {
        navigate('/login'); // Kullanıcıyı login sayfasına yönlendir
    };

    return (
        <Result
            status="403"
            title="403"
            subTitle="Sorry, you are not authorized to access this page."
            extra={<Button type="primary" onClick={onClick}>Go to Login Page</Button>}
        />
    );
};

export default App;
