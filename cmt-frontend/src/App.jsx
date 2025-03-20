import React, { useEffect, useState } from 'react';
import Cookies from 'js-cookie';
import { Outlet, useNavigate } from 'react-router-dom';
import Navbar from './shared/component/navbar';
import { removeToken } from './shared/cookie/cookie';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const navigate = useNavigate();


  useEffect(() => {
    removeToken('refreshToken');
    removeToken('accessToken');
    
  }, [navigate]);


  return (
    <>
        <Navbar/>
        <Outlet/>
    </>
  );
}

export default App;