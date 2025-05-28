import { LiaCartPlusSolid } from "react-icons/lia";
import API from "../Controller/Api";
import { useEffect } from "react";
import { Link, Navigate } from "react-router-dom";

function Button() {
    const navigate = Navigator
    function ClicaNiMim() {
        const token = localStorage.getItem('auth_token')
        console.log(token)
        if (token === null) {
            navigate("/inicio")
        } else {
            insertCart();
        }
        const insertCart = () => {
            try {
                const reponse = API.post(`carts/`)
            }
            catch (error) {
                console.log(error)
            }
        }
    }
    return (
        <div className="flex bg-[#1E4D05] rounded-[0.625rem] hover:scale-[1.05] justify-center w-20">
            <button onClick={() => { ClicaNiMim() }} className="flex w-10 text-center justify-center"><LiaCartPlusSolid className="text-white text-3xl" /></button>
        </div>
    )
}
export default Button;