import CartItem from "../../Components/CartItem";
import Template, { AppContext } from "../../Layout/Template";
import { useContext } from "react";

function Cart() {
    const { listCartItem, setListCartItem } = useContext(AppContext);

    return (
        <div className="px-20 2xl:px-100 pt-10 flex gap-5">
            <div>
                <h1 className="font-bold text-2xl">Meu carrinho</h1>
                {listCartItem.map(item => (
                    <div className="pt-5">
                        <CartItem key={item.cart_id} cartItem={item} setListCartItem={setListCartItem} />
                    </div>
                ))}
            </div>
            <div className="pt-13">
                <div className="flex flex-col bg-gray-200 p-5 w-80 rounded-[10px] hover:border border-red-700">
                    <div className="flex justify-between font-bold">
                        <h3>Total</h3>
                        <p>R$ {listCartItem.reduce((soma, sub) => soma + sub.subtotal, 0)}</p>
                    </div>
                    <button className="mt-5 p-1 items-center justify-center rounded-[10px] font-bold text-white bg-[#BF1919]">Comprar</button>
                </div>
                <div className="mt-5 w-full text-center hover:scale-[1.05] hover:text-[#BF1919]">
                    <a href="/home" className="font-medium">Buscar mais peças</a>
                </div>
            </div>
        </div>
    )
}
export default Cart;