import { Link } from "react-router-dom";
import Button from "./Button";
import { motion } from "framer-motion";

function Products({ products }) {
    return (
        <motion.div initial={{scale:0.5}} whileInView={{scale:1}} transition={{duration:0.1}} className="bg-white w-60 2xl:w-70 p-5 rounded-[0.625rem] shadow-sm shadow-slate-600 hover:border border-red-700">
            <Link to={`/produto/${products.id}`}>
                <img src="../../public/Porca Sextavada.jpeg" className="hover:scale-[1.05] duration-200 ease-out" alt="Produto" />
                <h3 className="font-bold text-center mb-5">{products.name}</h3>
                <p className="text-center h-20 overflow-auto">{products.description}</p>
                <p className="text-center"><span className="pr-2">Quantidade:</span>{products.stock}</p>
            </Link>
            <div className="flex gap-5 items-center justify-center">
                <p className="font-bold">Por: {products.price}</p>
                <Button product={products} />
            </div>
        </motion.div>
    )
}
export default Products;
