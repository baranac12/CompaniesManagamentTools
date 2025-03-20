import React, { useState } from "react";
import { Navigate, useLocation } from "react-router-dom";


const ProtectedRoute = ({ Component }) => {
    const currentPath = window.location.pathname;  // Geçerli sayfa yolunu alıyoruz.
    const statusCode = null;

    if (currentPath !== "/login") {
        // Eğer kullanıcı giriş yapmamışsa ve şu anki yol /login değilse,
        // Kullanıcıyı /notAuth sayfasına yönlendiriyoruz.
        return <Navigate to="/notAuth" />;
    }

    return <Component />;
};

export default ProtectedRoute;
