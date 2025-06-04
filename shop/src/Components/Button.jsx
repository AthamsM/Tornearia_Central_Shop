import { LiaCartPlusSolid } from "react-icons/lia";
import API from "../Controller/Api";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";

function Button( {product} ) {
    const navigate = useNavigate()
    const productId = product.id
    const quantity = 1
    function ClicaNiMim() {
        const token = localStorage.getItem('token')
        console.log(token)
        if (token === null) {
            navigate("/inicio")
        } else {
            insertCart();
        }
        async function insertCart(){
            try {
                const decodeToken = jwtDecode(token)
                const userId = decodeToken.id
                const reponse = API.post(`carts/${userId}?product_id=${productId}&quantity=${quantity}`)
                console.log(reponse)
            }
            catch (error) {
                console.log(error)
            }
        }
    }
    return (
        <div className="flex bg-[#1E4D05] rounded-[0.625rem] hover:scale-[1.05] justify-center w-20">
            <button onClick={() => { ClicaNiMim()}} className="flex w-10 text-center justify-center"><LiaCartPlusSolid className="text-white text-3xl" /></button>
        </div>
    )
}
export default Button;