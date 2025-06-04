import { MdAlternateEmail } from "react-icons/md";
import { HiOutlineLockClosed } from "react-icons/hi2";
import { PiUserCircleFill } from "react-icons/pi";
import { motion } from "framer-motion";

function Register({setStatus}) {
    return (
        <div className="grid grid-cols-2 overflow-hidden" style={{
            backgroundImage: "linear-gradient(to right, #BF1919 50%, white 50%)",
        }}>
            <motion.div animate={{translateX:[1080,3,1,0]}} className="bg-white flex items-center justify-center h-screen rounded-tr-[200px]">
                <div className="w-80 h-90 flex flex-col items-center justify-center rounded-[10px] shadow-lg shadow-gray-600">
                    <div>
                        <h1 className="pb-5 font-extrabold text-xl">Faça seu Cadastro</h1>
                        <div>
                            <form action=""></form>
                            <div className="flex">
                                <input type="text" placeholder="Nome" className="border-b outline-0 focus:border-b-green-500" />
                                <PiUserCircleFill />
                            </div>
                        </div>
                        <div className="pt-5">
                            <form action=""></form>
                            <div className="flex">
                                <input type="email" placeholder="Email" className="border-b outline-0 focus:border-b-green-500" />
                                <MdAlternateEmail />
                            </div>
                        </div>
                        <div className="pt-5">
                            <form action=""></form>
                            <div className="flex">
                                <input type="text" placeholder="Senha" className="border-b outline-0 focus:border-b-green-500" />
                                <HiOutlineLockClosed />
                            </div>
                        </div>
                        <div className="flex flex-col pt-5 place-items-center">
                            <button className="border w-30 h-8 rounded-[10px] bg-[#1E4D05] text-white">Cadastrar</button>
                            <p className="pt-2">Já tem uma conta? clique <button onClick={() => setStatus(true)} className="text-green-500 hover:scale-[1.03] hover:cursor-pointer">aqui</button></p>
                        </div>
                    </div>
                </div>
            </motion.div>
            <motion.div animate={{translateX:[-1080,-3,-1,0]}} className="bg-[#BF1919] flex flex-col items-center justify-center h-screen rounded-bl-[200px]">
                <img src="tc-start.png" alt="Tornearia Central logo" className="w-75 2xl:w-125" />
            </motion.div>
        </div>
    );
}
export default Register;