import React from 'react';
import { Button, Result } from 'antd';
import { useNavigate } from 'react-router-dom'; // useNavigate'ı import etmelisiniz

const App = () => {
    const navigate = useNavigate(); // useNavigate'ı bileşen içinde kullanın

    const onClick = () => {
        navigate('/dashboard'); // Kullanıcıyı login sayfasına yönlendir
    };

    return (
        <Result
            status="404"
            title="404"
            subTitle="Sorry, the page you visited does not exist."
            extra={<Button type="primary" onClick={onClick}>Back to Home</Button>} // onClick fonksiyonunu ekleyin
        />
    );
};

export default App;