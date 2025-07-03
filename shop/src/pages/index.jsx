import Login_Register from "./StartandRegister/Login_Register";
import Home from "./Home"
import ProductPage from "./ProductPage";
import Cart from "./Cart";
import Template from "../Layout/Template";
import Payments from "./Payment";
import Order from "./Order";

const Pages = [
    {
        path : "/",
        component : <Login_Register/>
    },
    {
        path : "/home",
        component : <Template><Home/></Template>
    },
    {
        path : "/produto/:id",
        component : <Template><ProductPage/></Template>
    },
    {
        path : "/cart",
        component : <Template><Cart/></Template>
    },
    {
        path : "/checkout",
        component : <Payments/>
    },
    {
        path : "/pedidos",
        component : <Template><Order/></Template>
    }
]
export default Pages;
