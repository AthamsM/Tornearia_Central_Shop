import { LiaCartPlusSolid } from "react-icons/lia";
import API from "../Controller/Api";
import { jwtDecode } from "jwt-decode";

function Button({ product, quant, setMensagem }) {
    const productId = product.id
    const quantity = quant ? quant : 1

    function addItemInCart() {
        const token = localStorage.getItem('token')
        if (token === null) {
            window.location.href = "/"
        } else {
            insertCart();
        }
        async function insertCart() {
            try {
                const decodeToken = jwtDecode(token)
                const userId = decodeToken.id
                const response = await API.post(`carts/${userId}?product_id=${productId}&quantity=${quantity}`)
                if(response.data){
                    setMensagem(true)
                }
                console.log(response)
            }
            catch (error) {
                console.log(error)
            }
        }
    }
    return (
        <div className="flex bg-[#1E4D05] active:bg-[#1f3015] rounded-[0.625rem] hover:scale-[1.05] justify-center w-20">
            <button onClick={() => { addItemInCart() }} className="flex w-10 text-center justify-center"><LiaCartPlusSolid className="text-white text-3xl" /></button>
        </div>
    )
}
export default Button;