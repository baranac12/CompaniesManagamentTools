import { createBrowserRouter } from 'react-router-dom'; // React Router v6'nın yeni API'si
import { Dashboard } from '../pages/dashboard';
import { Login } from '../pages/login';
import User from '../pages/user'
import NotAuth from '../pages/results/notAuth/index';
import NotPage from '../pages/results/notPage/'
import App from '../App';
import ProtectedRoute from './ProtectedRoute'; // ProtectedRoute bileşenini import et

export default createBrowserRouter([
    {
        path: "/login",
        element: <Login /> // Login sayfası her zaman erişilebilir
    },
    {
        path: "/notAuth",
        element: <NotAuth /> // Yetkisiz sayfa
    },
    {
        path: "*",  // Diğer tüm yollar için NotPage
        element: <NotPage />
    },
    {
        path: "/",
        element: <ProtectedRoute Component={App} />,  // Ana App bileşeni
        children: [
            {
                path: "dashboard",  // "/dashboard" yoluna gelir
                element: <ProtectedRoute Component={Dashboard} />  // ProtectedRoute ile korunan bir rota
            },
            {
                path: "management",  // "/management" yoluna gelir
                element: <ProtectedRoute Component={User} />,  // ProtectedRoute ile korunan bir rota
                children: [
                    {
                        path: "users",  // "/management/users" yoluna gelir
                        element: <ProtectedRoute Component={User} />,  // ProtectedRoute ile korunan bir rota
                    }
                ]
            }
        ]
    }
]);
