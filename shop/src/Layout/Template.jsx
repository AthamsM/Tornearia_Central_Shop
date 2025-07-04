import Navbar from "./Navbar";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { createContext } from 'react';
import API from "../Controller/Api";

export const AppContext = createContext()

function Template({ children }) {
    const token = localStorage.getItem("token");
    const [userName, setUserName] = useState("Usuario")
    const [listCartItem, setListCartItem] = useState([])
    const [cartItem, setCartItem] = useState(0) //quantidade
    const [mensagem, setMensagem] = useState(false)
    const [search, setSearch] = useState("")
    
    useEffect(() => {
        if (token) {
            const decodeToken = jwtDecode(token)
            setUserName(decodeToken.name)
        }
    }, [token])
    useEffect(() => {
        const getQuantityCartItem = async () => {
            try {
                const decodeToken = jwtDecode(token)
                const response = await API.get(`/carts/items/${decodeToken.id}`)
                const value = response.data
                setCartItem(value.length)
                setListCartItem(value)
            } catch (error) {
                console.log(error)
            }
        }
        getQuantityCartItem()
    }, [listCartItem, cartItem, mensagem])

    return (
        <AppContext.Provider value={{listCartItem, setListCartItem, setMensagem, search, setSearch}}>
            <Navbar cartItem={cartItem} userName={userName} search={search} setSearch={setSearch} mensagem={mensagem} setMensagem={setMensagem}/>
            {children}
        </AppContext.Provider>
    )
}
export default Template;