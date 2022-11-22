import cart from '../assets/vectors/cart.svg'

const Cart = () => {
  return (
    
    <button className=" hover:bg-yellow-200 rounded p-2">
        <img src={cart} className="w-16 max-lg:w-8" alt="cart"/>
    </button>
   
  )
}

export default Cart