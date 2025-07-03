import { useEffect, useState } from "react"
import API from "../../Controller/Api"
import OrderItem from "../../Components/OrderItem"

function Order() {
    const [orderList, setOrderList] = useState([])
    useEffect(() => {
        const getListOrder = async () => {
            try {
                const response = await API.get(`/orders/${3}`)
                setOrderList(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        getListOrder()
    }, [setOrderList])
    return (
        <div>
            {orderList.slice().reverse().map(item => (
                <div key={item.id} className="px-60 2xl:px-90 pt-5">
                    <OrderItem item={item}/>
                </div>
            ))}
        </div>
    )
}
export default Order