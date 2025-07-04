import { useEffect, useState } from "react"
import API from "../Controller/Api"

function OrderItem({ item }) {
    const [orderItemList, setOrderItemList] = useState([])
    useEffect(() => {
        const getListOrderList = async () => {
            try {
                const response = await API.get(`/orders/items/${item.id}`)
                setOrderItemList(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        getListOrderList()
    }, [setOrderItemList])
    return (
        <div>
            {orderItemList.map(itemList =>
                <div key={itemList.id} className="grid px-10 my-2 rounded-[10px] bg-white shadow-lg shadow-gray-600  hover:border border-red-700">
                    <div className="pt-3 place-items-start"><h3 className="text-green-500 font-bold w-full border-b-2">{itemList.order.status}</h3></div>
                    <div className="pt-3 grid grid-cols-3 place-items-center ">
                        <div className="col-span-2 place-content-start" >
                            <div className="grid grid-cols-2 place-items-center">
                                <div className="">
                                    <p className="text-2xl">{itemList.product.name}</p>
                                    <p className="text-justify">{itemList.product.description}</p>
                                    <div><p className="pt-5 text-2xl">R$ {itemList.subtotal}</p></div>
                                </div>
                            </div>
                        </div>
                        <div className="flex items-end">
                            <img src={`/products/${itemList.product.name}.jpg`} alt="" className="w-40" />
                            <p className="pl-2">{itemList.quantity}x</p>
                        </div>
                    </div>
                </div>
            )}
        </div>
    )
}
export default OrderItem