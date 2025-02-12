import React from "react";
import { Outlet } from "react-router-dom";
import Navbar from "./shared/component/navbar";
import { Provider } from "react-redux";
import store from './redux/store'
function App() {
    return (
        <>
            <Provider store={store}>
                <Navbar />
                <Outlet />
            </Provider>
        </>
    )
}
export default App;