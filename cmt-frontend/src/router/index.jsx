import { createBrowserRouter } from 'react-router-dom'; // React Router v6'nın yeni API'si
import { Dashboard } from '../pages/dashboard';
import { Login } from '../pages/login';
import App from '../App';
import ProtectedRoute from './ProtectedRoute'; // ProtectedRoute bileşenini import et

export default createBrowserRouter([
    {
        path: "/login",
        element: <Login /> // Login sayfası her zaman erişilebilir
    },
    {
        path: "/",
        element: <ProtectedRoute Component={App} />,  // Ana App bileşeni
        children: [
            {
                path: "dashboard",  // "/dashboard" yoluna gelir
                index: true,
                element: <ProtectedRoute Component={Dashboard} />  // ProtectedRoute ile korunan bir rota
            }
        ]
    }
]);
