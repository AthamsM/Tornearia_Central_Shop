import { MdAlternateEmail } from "react-icons/md";
import { HiOutlineLockClosed } from "react-icons/hi2";
import { useState } from "react";
import API from "../../Controller/Api";
import { motion } from "framer-motion";
import { useNavigate } from "react-router-dom";

function Start( {setStatus} ) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault(); 
        try{
            const response = await API.post("/users/auth", {email, password})
            console.log(response.data)
            if(response.data.token){
                localStorage.setItem("token", response.data.token)
                navigate("/home")
            }else{
                alert(response.data)
            }
        }catch(error){
            console.log(error)
        }
    }
    return (
        <div className="grid grid-cols-2 overflow-hidden" style={{
            backgroundImage: "linear-gradient(to right, white 50%, #BF1919 50%)",
        }}>
            <motion.div animate= {{translateX:[1080,3,1,0]}} className="bg-[#BF1919] flex flex-col items-center justify-center h-screen rounded-tr-[200px]">
                <img src="tc-start.png" alt="Tornearia Central logo" className="w-75 2xl:w-125" />
            </motion.div>
            <motion.div animate= {{translateX:[-1080,-3,-1,0]}} className="bg-white flex items-center justify-center h-screen rounded-bl-[200px]">
                <div className="w-80 h-80 flex flex-col items-center justify-center rounded-[10px] shadow-lg shadow-gray-600">
                    <form onSubmit={handleSubmit}>
                        <h1 className="pb-10 font-extrabold text-xl">Faça seu login</h1>
                        <div>
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
                        <div className="flex flex-col pt-8 place-items-center">
                            <button type="submit" className="border w-30 h-8 rounded-[10px] bg-[#1E4D05] text-white">Entrar</button>
                            <p className="pt-2">Usuário novo? clique <button onClick={() => setStatus(false)} className="text-green-500 hover:scale-[1.03] hover:cursor-pointer">aqui</button></p>
                        </div>
                    </form>
                </div>
            </motion.div>
        </div>
    );
}
export default Start;