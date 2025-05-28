import Products from "../../Components/Products";
import Navbar from "../../Layout/Navbar";
import API from "../../Controller/Api"
import React, {useState, useEffect} from "react"

function Home(){
    const [produtos, setProdutos] = useState([]);
    useEffect (()=>{
        const getProducts = async ()=> {
            try{
                const response = await API.get("/products/list")
                console.log("dados da API:",response.data)
                setProdutos(response.data)
            }catch(error){
                console.log(error)
            }
        }
        getProducts()
    }, [])
    return(
        <div className="bg-[#F5F5F5] flex flex-col min-h-screen">
            <Navbar/>
            <div className="p-20 grid grid-cols-4 gap-7 2xl:grid-cols-5 2xl:gap-10 h-full">
                {produtos.map(products => (
                    <Products key={products.id} products={products}/>
                ))}
            </div>
        </div>

    )
}
export default Home;
