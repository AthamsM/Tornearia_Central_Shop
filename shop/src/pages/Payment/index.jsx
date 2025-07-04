import { CardPayment } from "@mercadopago/sdk-react";
import { initMercadoPago } from "@mercadopago/sdk-react";
import API from "../../Controller/Api";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { ToastContainer } from "react-toastify";

function Payments() {
    const token = localStorage.getItem('token')
    const decodeToken = jwtDecode(token)
    const userId = decodeToken.id
    const [totalPrice, setTotalPrice] = useState(null)
    const esperar = (ms) => new Promise(resolve => setTimeout(resolve, ms));

    useEffect(() => {
        initMercadoPago("SUA_CHAVE_PUBLICA", { locale: 'pt-BR' });
    }, []);

    useEffect(() => {
        const getTotalPrice = async () => {
            try {
                const response = await API.get(`/carts/${userId}`)
                setTotalPrice(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        getTotalPrice()
    }, [userId])
    if (totalPrice === null) {
        return <p>Carregando valor...</p>;
    }
    async function createPayment(paymentMethod) {
        try {
            const response = await API.post("/payments", { userId, paymentMethod, amount: totalPrice })
            await createOrder(response.data.id)
        } catch (error) {
            console.log(error)
        }
    }
    async function createOrder(paymentId) {
        try {
            const response = await API.post("/orders", { userId, paymentId, totalPrice })
        } catch (error) {
            console.log(error)
        }
    }
    async function checkoutPaymentMP(cardFormData) {
        try {
            const response = await API.post("/payments/pay", {
                token: cardFormData.token,
                transactionAmount: cardFormData.transaction_amount,
                description: "Compra teste",
                installments: cardFormData.installments,
                paymentMethodId: cardFormData.payment_method_id,
                issuerId: cardFormData.issuer_id,
                email: cardFormData.payer?.email,
                cpf: cardFormData.payer?.identification?.number
            });
            if (response.data.status == "approved") {
                const mpType = response.data.payment_type_id === "credit_card" ? "CREDIT" : "DEBIT";
                createPayment(mpType);
            }  
            toast("Compra realizada com sucesso!", { position: "top-right", autoClose: 3000, hideProgressBar: false, closeOnClick: true, pauseOnHover: true, draggable: true, progress: undefined, theme: "light", })
            await esperar(3000)
            window.location.href = "/pedidos"

        } catch (error) {
            console.error("Erro no pagamento:", error);
        }
    }
    return (
        <div>
            <ToastContainer position="top-right" autoClose={3000} />
            <CardPayment initialization={{ amount: totalPrice }} onSubmit={async (cardFormData) => { checkoutPaymentMP(cardFormData) }}/>
        </div>
    );
}

export default Payments;
