import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:8080/api",
})

API.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token");
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

API.interceptors.response.use(
    (response) => {
        return response;
    },
    (error) => {
        if (error.response && (error.response.status === 401 || error.response.status === 403)) {
            // Remove token inválido
            localStorage.removeItem("token");
            // Redireciona
            window.location.href = "/";
        }
        return Promise.reject(error);
    }
);

export default API;
