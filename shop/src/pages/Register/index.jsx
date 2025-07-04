import { MdAlternateEmail } from "react-icons/md";
import { HiOutlineLockClosed } from "react-icons/hi2";
import { PiUserCircleFill } from "react-icons/pi";
import { motion } from "framer-motion";
import { useState } from "react";
import API from "../../Controller/Api";
import { ToastContainer, toast } from 'react-toastify';

function Register({ setStatus }) {
    const [name, setName] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")
    const esperar = (ms) => new Promise(resolve => setTimeout(resolve, ms));

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!name || !email || !password) {
            toast("Preencha todos os campos.", { position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light", });
            return
        }
        try {
            const response = await API.post("users/register", { name, email, password })
            if (response.data) {
                toast("Cadastro realizado com sucesso.", { position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light", })
                await esperar(3000)
                setStatus(true)
            } else {
                toast("Erro ao cadastrar. Tente novamente.", { position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light", })
                await esperar(3000)
                return
            }
        } catch (error) {
            toast("Erro ao conectar-se ao servidor!", {position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light",})
            await esperar(3000)
            return
        }
    }
    return (
        <div className="grid grid-cols-2 overflow-hidden" style={{
            backgroundImage: "linear-gradient(to right, #BF1919 50%, white 50%)",
        }}>
            <motion.div animate={{ translateX: [1080, 3, 1, 0] }} className="bg-white flex items-center justify-center h-screen rounded-tr-[200px]">
                <div className="w-80 h-90 flex flex-col items-center justify-center rounded-[10px] shadow-lg shadow-gray-600">
                    <form onSubmit={handleSubmit}>
                        <h1 className="pb-5 font-extrabold text-xl">Faça seu Cadastro</h1>
                        <div>
                            <div className="flex">
                                <input type="text" placeholder="Nome" value={name} onChange={(e) => setName(e.target.value)} className="border-b outline-0 focus:border-b-green-500" />
                                <PiUserCircleFill />
                            </div>
                        </div>
                        <div className="pt-5">
                            <div className="flex">
                                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" className="border-b outline-0 focus:border-b-green-500" />
                                <MdAlternateEmail />
                            </div>
                        </div>
                        <div className="pt-5">
                            <div className="flex">
                                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Senha" className="border-b outline-0 focus:border-b-green-500" />
                                <HiOutlineLockClosed />
                            </div>
                        </div>
                        <div className="flex flex-col pt-5 place-items-center">
                            <button type="submit" className="border w-30 h-8 rounded-[10px] bg-[#1E4D05] text-white hover:scale-[1.05] active:bg-[#1e4d05dc] cursor-pointer">Cadastrar</button>
                            <p className="pt-2">Já tem uma conta? clique <button onClick={() => setStatus(true)} className="text-green-500 hover:scale-[1.03] hover:cursor-pointer">aqui</button></p>
                        </div>
                    </form>
                </div>
            </motion.div>
            <motion.div animate={{ translateX: [-1080, -3, -1, 0] }} className="bg-[#BF1919] flex flex-col items-center justify-center h-screen rounded-bl-[200px]">
                <img src="tc-start.png" alt="Tornearia Central logo" className="w-75 2xl:w-125" />
                <ToastContainer position="top-right" autoClose={3000} />
            </motion.div>
        </div>
    );
}
export default Register;