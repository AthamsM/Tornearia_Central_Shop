import { CgShoppingCart } from "react-icons/cg";
import { LiaCartPlusSolid } from "react-icons/lia";

function Products({products}){
    return(
        <div className="bg-white w-50 p-5 rounded-[0.625rem] shadow-sm shadow-slate-600 hover:border border-red-700">
            <img src="../../public/Porca Sextavada.jpeg" className="hover:scale-[1.05] duration-200 ease-out" alt="Produto" />
            <h3 className="font-bold text-center mb-5">{products.name}</h3>
            <p className="text-center h-20">{products.description}</p>
            <div className="flex gap-5 items-center justify-center">
                <p className="font-bold">Por: {products.price}</p>
                <div className="flex bg-[#1E4D05] rounded-[0.625rem] hover:scale-[1.05]">
                    <button className="flex w-10 text-center justify-center"><LiaCartPlusSolid className="text-white text-3xl" /></button>
                </div>
            </div>
        </div>
    )
}
export default Products;