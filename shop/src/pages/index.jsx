import Login_Register from "./teste/Login_Register";
import Home from "./Home"
import ProductPage from "./ProductPage";
import Register from "./Register";
import Start from "./Start";

const Pages = [
    {
        path : "/inicio",
        component : <Login_Register/>
    },
    {
        path : "/home",
        component : <Home/>
    },
    {
        path : "/produto/:id",
        component : <ProductPage/>
    }
]
export default Pages;
