import Navbar from "./Navbar";


function Template({children}){
    return(
        <div>
            <Navbar></Navbar>
            {children}
        </div>
    )
}
export default Template;