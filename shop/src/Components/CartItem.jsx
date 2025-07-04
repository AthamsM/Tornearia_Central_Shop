import { BiTrash } from "react-icons/bi";
import { AiTwotonePlusSquare } from "react-icons/ai";
import { AiTwotoneMinusSquare } from "react-icons/ai";
import API from "../Controller/Api";
import { Link } from "react-router-dom";

function CartItem({ cartItem, setListCartItem }) {

    async function updateCartItem(value) {
        try {
            await API.put(`/carts/${cartItem.cart_id}?quantity=${value}`)
        } catch (error) {
            console.log(error)
        }
    }
    async function deleteItemCart() {
        try {
            await API.delete(`/carts/item/${cartItem.cart_id}`)
        } catch (error) {
            console.log(error)
        }
    }
    async function deleteCartItem() {
        try {
            await API.delete(`/carts/${cartItem.cart.id}`)
        } catch (error) {
            console.log(error)
        }
    }

    return (
        <div className="px-10 py-2 grid grid-cols-4 place-items-center rounded-[10px] shadow-lg shadow-gray-600  hover:border border-red-700">
            <Link to={`/produto/${cartItem.product.id}`} className="col-span-2" >
                <div className="grid grid-cols-2 place-items-center">
                    <div className="place-content-start" >
                        <img src={`/products/${cartItem.product.name}.jpg`} alt="" className="w-40" />
                    </div>
                    <div>
                        <p className="text-2xl">{cartItem.product.name}</p>
                        <p className="text-justify">{cartItem.product.description}</p>
                    </div>
                </div>
            </Link>
            <div>
                <div className="flex text-3xl gap-1">
                    <button onClick={() => { updateCartItem(-1) }} className=" active:bg-amber-300 hover:scale-[1.05]"><AiTwotoneMinusSquare /></button>
                    <p>{cartItem.quantity}</p>
                    <button onClick={() => { updateCartItem(1) }} className=" active:bg-amber-300 hover:scale-[1.05]"><AiTwotonePlusSquare /></button>
                    <button onClick={() => { deleteItemCart() }} className=" active:bg-amber-300 hover:scale-[1.05]"><BiTrash /></button>
                </div>
            </div>
            <div><p className="font-bold text-3xl">R$ {cartItem.subtotal}</p></div>
        </div>
    )
}
export default CartItem