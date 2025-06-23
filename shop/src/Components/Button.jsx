import { LiaCartPlusSolid } from "react-icons/lia";
import API from "../Controller/Api";
import { jwtDecode } from "jwt-decode";

function Button( {product, quant} ) {
    const productId = product.id
    const quantity = quant? quant : 1
    function addItemInCart() {
        const token = localStorage.getItem('token')
        console.log(token)
        if (token === null) {
            window.location.href ="/"
        } else {
            insertCart();
        }
        async function insertCart(){
            try {
                const decodeToken = jwtDecode(token)
                const userId = decodeToken.id
                const reponse = await API.post(`carts/${userId}?product_id=${productId}&quantity=${quantity}`)
                console.log(reponse)
            }
            catch (error) {
                console.log(error)
            }
        }
    }
    return (
        <div className="flex bg-[#1E4D05] active:bg-amber-300 rounded-[0.625rem] hover:scale-[1.05] justify-center w-20">
            <button onClick={() => { addItemInCart()}} className="flex w-10 text-center justify-center"><LiaCartPlusSolid className="text-white text-3xl" /></button>
        </div>
    )
}
export default Button;