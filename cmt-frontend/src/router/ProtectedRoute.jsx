import React, { useState } from "react";
import { Navigate, useLocation } from "react-router-dom";
import { useSelector } from "react-redux";

const ProtectedRoute = ({ Component }) => {
    const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);
    const currentPath = window.location.pathname;  // Geçerli sayfa yolunu alıyoruz.
    const statusCode = null;

    if (!isAuthenticated && currentPath !== "/login") {
        // Eğer kullanıcı giriş yapmamışsa ve şu anki yol /login değilse,
        // Kullanıcıyı /notAuth sayfasına yönlendiriyoruz.
        return <Navigate to="/notAuth" />;
    }

    return <Component />;
};

export default ProtectedRoute;
