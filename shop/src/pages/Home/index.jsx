import Products from "../../Components/Products";
import API from "../../Controller/Api"
import {useState, useEffect, useContext} from "react"
import { AppContext } from "../../Layout/Template";

function Home(){
    const { setMensagem, search } = useContext(AppContext);
    const [produtos, setProdutos] = useState([]);
    const removeAccent = (texto) => texto.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
    const produtosSearch = produtos.filter(produto => removeAccent(produto.name.toLowerCase()).includes(search.toLowerCase()))
    useEffect (()=>{
        const getProducts = async ()=> {
            try{
                const response = await API.get("/products/list")
                setProdutos(response.data)
            }catch(error){
                console.log(error)
            }
        }
        getProducts()
    }, [setProdutos])
    return(
        <div className="bg-[#F5F5F5] flex flex-col min-h-screen">
            <div className="p-20 grid grid-cols-4 gap-7 2xl:grid-cols-5 2xl:gap-10 h-full">
                {produtosSearch.map(products => (
                    <Products key={products.id} products={products} setMensagem={setMensagem}/>
                ))}
            </div>
        </div>

    )
}
export default Home;
