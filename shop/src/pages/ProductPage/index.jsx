import { useParams } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import Navbar from "../../Layout/Navbar";
import API from "../../Controller/Api";
import Button from "../../Components/Button";
import Template, { AppContext } from "../../Layout/Template";

function ProductPage() {
    const { id } = useParams();
    const [product, setProduct] = useState({});
    const [quantity, setQuantity] = useState("1")
    const { setMensagem } = useContext(AppContext);

    useEffect(() => {
        const getProdut = async () => {
            try {
                const response = await API.get(`/products/product/${id}`)
                setProduct(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        getProdut()
    }, [])

    return (
        <div className="bg-[#F5F5F5] h-screen">
            <div className="grid place-items-center">
                <div className="flex items-center m-20 gap-15 w-1/2 rounded-[10px] shadow-lg shadow-slate-600 hover:scale-[1.008] duration-200 ease-out">
                    <div>
                        <img src={`/products/${product.name}.jpg`} alt="produto" className="w-100 rounded-[10px] 2xl:w-150" />
                    </div>
                    <div className="m-5">
                        <h1 className="text-2xl font-bold mb-5">{product.name}</h1>
                        <h2 className="text-xl font-bold mb-5">Por: R${product.price}</h2>
                        <h3 className="text-lg font-semibold">Descrição:</h3>
                        <p className="mb-5 text-lg">{product.description}</p>
                        <div className="flex">
                            <p className="pr-2">Quantidade:</p>
                            <input type="number" value={quantity} className="w-10" onChange={(e) => setQuantity(e.target.value)}/>
                        </div>
                        <div className="my-1">
                            <Button product={product} quant={quantity} setMensagem={setMensagem}/>
                        </div>
                        <p className="text-end">Estoque: {product.stock}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProductPage;
