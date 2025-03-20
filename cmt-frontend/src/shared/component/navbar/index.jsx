import { React, useEffect } from "react";
import { Menu, Avatar, Dropdown, Button } from "antd";
import { DashboardOutlined, TeamOutlined, SettingOutlined, UserOutlined, DatabaseOutlined, DollarOutlined, ShoppingCartOutlined, CodeSandboxOutlined, HistoryOutlined, LogoutOutlined, UnlockOutlined } from "@ant-design/icons";
import { useNavigate } from "react-router-dom";
import { logoutUser } from "../../../pages/login/api";
import logo from "../../../assets/logo.png";
import "./navbar.css"; // CSS dosyasını içe aktar
import { Header } from "antd/es/layout/layout";


const items = [
    { label: 'Dashboard', key: "dashboard", icon: <DashboardOutlined style={{ fontSize: '20px' }} />, path: '/dashboard' },
    { label: 'Finance', key: "finance", icon: <DollarOutlined style={{ fontSize: '20px' }} />, path: '/finance' },
    { label: 'Orders', key: "orders", icon: <ShoppingCartOutlined style={{ fontSize: '20px' }} />, path: '/orders' },
    { label: 'Products', key: "products", icon: <CodeSandboxOutlined style={{ fontSize: '20px' }} />, path: '/products' },
    { label: 'Employee', key: "employee", icon: <TeamOutlined style={{ fontSize: '20px' }} />, path: '/employee' },
    {
        label: 'Management Panel', key: "management", icon: <SettingOutlined style={{ fontSize: '20px' }} />,
        items: [
            { label: 'Users', key: "users", icon: <UserOutlined />, path: '/management/users' },
            { label: 'Role', key: "role", icon: <UnlockOutlined />, path: '/management/role' },
            { label: 'Employees', key: "employees", icon: <TeamOutlined />, path: '/management/employees' },
            { label: 'Data', key: "data", icon: <DatabaseOutlined />, path: '/management/data' },
            { label: 'System Log', key: "log", icon: <HistoryOutlined />, path: '/management/log' }
        ]
    }
];

const Navbar = () => {
    const navigate = useNavigate();

    const handleMenuClick = (path) => {
        navigate(path);  // Yönlendirme işlemi
    };

    const handleLogout = async () => {
        
        navigate('/login');
        await logoutUser();
    };

    const userMenu = (
        <Menu>
            <Menu.Item key="settings">
                <a href="/settings">Settings</a>
            </Menu.Item>
            <Menu.Divider />
            <Menu.Item key="logout" icon={<LogoutOutlined />} onClick={handleLogout}>
                Logout
            </Menu.Item>
        </Menu>
    );

    return (
        <Header>
            <div style={{ display: "flex", alignItems: "center", background: "#001529", justifyContent: "space-between" }}>
                {/* Logo */}
                <img src={logo} alt="Logo" style={{ height: '50px' }} />
                {/* Menü */}
                <Menu mode="horizontal" theme="dark" style={{ flex: 1, display: 'flex', justifyContent: 'center' }} items={items.map(item => (
                    !item.items ? ( // Eğer items yoksa doğrudan menü öğesini göster
                        {
                            key: item.key,
                            icon: item.icon,
                            label: item.label,
                            onClick: () => handleMenuClick(item.path)  // Tıklandığında yönlendirme
                        }
                    ) : (
                        // Eğer items varsa, SubMenu kullanarak alt öğeleri göster
                        {
                            key: item.key,
                            icon: item.icon,
                            label: item.label,
                            children: item.items.map(subItem => ({
                                key: subItem.key,
                                icon: subItem.icon,
                                label: subItem.label,
                                onClick: () => handleMenuClick(subItem.path)  // Tıklandığında yönlendirme
                            }))
                        }
                    )
                ))} />
                <div style={{ display: "flex", alignItems: "center" }}>
                    {/* Kullanıcı Avatarı ve Dropdown */}
                    <Avatar src="https://www.w3schools.com/w3images/avatar2.png" />
                    <Dropdown overlay={userMenu} trigger={['click']}>
                        <Button type="link" style={{ color: "white" }}>
                            "admin"
                        </Button>
                    </Dropdown>
                </div>
            </div>
        </Header>
    );
};

export default Navbar;
