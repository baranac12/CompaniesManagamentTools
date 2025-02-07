import React from "react";
import { Menu, Avatar, Dropdown, Button } from "antd";
import { DashboardOutlined, TeamOutlined, SettingOutlined, UserOutlined, DatabaseOutlined, DollarOutlined, ShoppingCartOutlined, CodeSandboxOutlined, HistoryOutlined, LogoutOutlined } from "@ant-design/icons";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { dropUser } from "../../../redux/userSlice";
import { logout } from "../../../redux/authSlice";
import { logoutUser } from "../../../pages/login/api";

import "./navbar.css"; // CSS dosyasını içe aktar


const items = [
    { label: <span className="menu-item">Dashboard</span>, key: "dashboard", icon: <DashboardOutlined style={{ fontSize: '20px' }} /> },
    { label: <span className="menu-item">Finance</span>, key: "finance", icon: <DollarOutlined style={{ fontSize: '20px' }} /> },
    { label: <span className="menu-item">Orders</span>, key: "orders", icon: <ShoppingCartOutlined style={{ fontSize: '20px' }} /> },
    { label: <span className="menu-item">Products</span>, key: "products", icon: <CodeSandboxOutlined style={{ fontSize: '20px' }} /> },
    { label: <span className="menu-item">Employee</span>, key: "employee", icon: <TeamOutlined style={{ fontSize: '20px' }} /> },
    {
        label: <span className="menu-item">Management Panel</span>,
        key: "management",
        icon: <SettingOutlined style={{ fontSize: '20px' }} />,
        children: [
            { label: <span className="menu-item">Users</span>, key: "users", icon: <UserOutlined /> },
            { label: <span className="menu-item">Employees</span>, key: "employees", icon: <TeamOutlined /> },
            { label: <span className="menu-item">Data</span>, key: "data", icon: <DatabaseOutlined /> },
            { label: <span className="menu-item">System Log</span>, key: "log", icon: <HistoryOutlined /> }
        ]
    }
];
const Navbar = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const users = useSelector((state) => state.users.users);
    const handleLogout = async () => {
        await logout();
        dispatch(dropUser());
        dispatch(logout());
        dispatch(logoutUser);
        navigate('/login');
    };
    const userMenu = (
        <Menu>
            <Menu.Item key="profile">
                <a href="/profile">Profile</a>
            </Menu.Item>
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
        <div style={{ display: "flex", alignItems: "center", background: "#001529", padding: "0 20px" }}>
            {/* Logo */}
            <img src="src/assets/900952.png" alt="Logo" style={{ width: '10vh' }} />

            {/* Menü */}
            <Menu mode="horizontal" theme="dark" items={items} style={{ flex: 1, display: 'flex', justifyContent: 'center' }} />
            <div style={{ display: "flex", alignItems: "center" }}>
                {/* Kullanıcı Avatarı ve Dropdown */}
                <Avatar src="https://www.w3schools.com/w3images/avatar2.png" style={{ marginRight: "10px" }} />
                <Dropdown overlay={userMenu} trigger={['hover']}>
                    <Button type="link" style={{ color: "white" }}>
                        {users.name} {users.surname}
                    </Button>
                </Dropdown>
            </div>
        </div>

    );
};

export default Navbar;
