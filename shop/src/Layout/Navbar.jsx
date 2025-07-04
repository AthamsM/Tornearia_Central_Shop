import { IoMdSearch } from "react-icons/io";
import { CgShoppingCart } from "react-icons/cg";
import { PiUserCircleFill } from "react-icons/pi";
import { Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { toast, ToastContainer } from "react-toastify";

function Navbar({ cartItem, userName, search, setSearch, mensagem, setMensagem }) {
    const navigate = useNavigate()
    const [input, setInput] = useState()
    const esperar = (ms) => new Promise(resolve => setTimeout(resolve, ms));
    
    useEffect(() => {
        const showMensagem = async () => {
            if (mensagem) {
                toast("Item adicionado no seu carrinho!", { position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light", })
                setMensagem(false)
                await esperar(3000)
            }
        }
        showMensagem()
    },[mensagem])
    function cartClick() {
        const token = localStorage.getItem('token')
        if (token === null) {
            window.location.href = "/"
        } else {
            navigate("/cart")
        }
    }

    function ordersClick() {
        const token = localStorage.getItem('token')
        if (token === null) {
            window.location.href = "/"
        } else {
            navigate("/pedidos")
        }
    }
    function searchButton(){
        setSearch(input)
    }

    return (
        <div className="bg-[#BF1919] px-25 h-[8rem] flex items-center justify-between">
            <Link to={"/home"} className="flex items-center gap-3 hover:scale-[1.05]">
                <img src="../../public/tc-logo.webp" alt="Torneria" className="h-10" />
                <h3 className="text-white font-bold text-2xl pr-10">Tornearia Central</h3>
            </Link>
            <div className="flex items-center gap-3">
                <input type="text" value={input} onChange={(e) => setInput(e.target.value)} className="outline-none bg-white rounded-[0.625rem] p-4 w-[35rem] h-10" placeholder="Busque aqui" />
                <button onClick={searchButton} className="bg-[#1E4D05] rounded-[0.625rem] w-10 h-10 flex justify-center items-center"><IoMdSearch className="text-white text-2xl" /></button>
            </div>
            <div className="flex items-center gap-5">
                <button onClick={() => { cartClick() }} className="relative hover:scale-[1.05]">
                    <div className="flex justify-end"><div className="flex bg-white rounded-full h-5 w-5 items-center justify-center mt-5 absolute translate-x-3 -translate-y-6"><p>{cartItem}</p></div></div>
                    <CgShoppingCart className="text-white text-4xl" />
                </button>
                <div>
                    <ToastContainer position="top-right" autoClose={3000} />
                    <button onClick={() => { ordersClick() }} className="relative hover:scale-[1.05]">
                        <PiUserCircleFill className="text-white text-5xl" />
                        <p className="text-white text-center">{userName}</p>
                    </button>
                </div>
            </div>
        </div>
    )
}
export default Navbar;