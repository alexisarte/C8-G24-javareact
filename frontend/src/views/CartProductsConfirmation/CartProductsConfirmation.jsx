import dogFood from "../../assets/dog-food.jpg";

const CartProductsConfirmation = () => {
    
    const subtotal = 6500;
    const shipTotal = 500;
    const total = subtotal + shipTotal;

  return (
    <>
    <img src={dogFood} className="justify-self-center "></img>
        <p className="text-lg border-solid border-b-2 pt-4 pb-8">
          Alimento pro plan x 10 kg
        </p>
        <div className="max-md:py-8">
          <div className="flex justify-between ">
            <p>Subtotal</p>
            <p>{subtotal}</p>
          </div>
          <div className="flex justify-between">
            <p>Envio:</p>
            <p>{shipTotal}</p>
          </div>
        </div>
        <div className="flex justify-between text-lg  border-solid border-t-2 py-8">
          <p>Total</p>
          <p>{total}</p>
        </div>
        </>
  )
}

export default CartProductsConfirmation