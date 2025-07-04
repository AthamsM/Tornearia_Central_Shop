import { Link } from "react-router-dom";
import Button from "./Button";
import { motion } from "framer-motion";

function Products({ products, setMensagem }) {
    return (
        <motion.div initial={{scale:0.5}} whileInView={{scale:1}} transition={{duration:0.1}} className="bg-white w-60 2xl:w-70 p-5 rounded-[0.625rem] shadow-sm shadow-slate-600 hover:border border-red-700">
            <Link to={`/produto/${products.id}`}>
                <img src= {`/products/${products.name}.jpg`} className="min-h-48 hover:scale-[1.05] duration-200 ease-out 2xl:min-h-60" alt="Produto" />
                <h3 className="font-bold text-center mb-5">{products.name}</h3>
                <p className="text-center h-20 overflow-auto">{products.description}</p>
            </Link>
            <div className="flex gap-5 items-center justify-center">
                <p className="font-bold">Por: R${products.price}</p>
                <Button product={products} setMensagem={setMensagem} />
            </div>
            <div className="mt-5">
                <p className="text-end"><span className="pr-2">Estoque:</span>{products.stock}</p>
            </div>
        </motion.div>
    )
}
export default Products;
