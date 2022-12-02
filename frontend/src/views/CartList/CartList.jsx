import React from 'react'
import { Card } from "flowbite-react";

export const CartList = ({products}) => {
  return (
    <Card>
    <div className="mb-4 flex items-center justify-between">
      <h5 className="text-xl font-bold leading-none text-gray-900 dark:text-white">
        Carrito de compras
      </h5>
    </div>
    <div className="flex">
      <p className="basis-5/6">Producto</p>
      <p className="basis-1/3 text-center">Cantidad</p>
      <p className="basis-1/3 text-right">Precio</p>
    </div>
    {products.map((item) => {
    return(
      <>
        <div className="flow-root">
      <ul className="divide-y divide-gray-200 dark:divide-gray-700">
        <li className="py-3 sm:py-4">
          <div className="flex items-center space-x-4">
            <div className="shrink-0">
              <img
                className="h-8 w-8 rounded-full"
                src={item.img}
                alt="img producto"
              />
            </div>
            <div className="min-w-0 basis-4/5">
              <p className="truncate text-sm font-medium text-gray-900 dark:text-white">
                {item.product}
              </p>
              <p className="truncate text-sm text-gray-500 dark:text-gray-400">
               {item.precio} + envio
              </p>
            </div>
            <div className="basis-1/3">
              <p className="text-center">{item.cantidad}</p>
            </div>
            <div className="text-base font-semibold text-gray-900 dark:text-white basis-1/3">
            <p className="text-right">$ {item.precio}</p> 
            </div>
          </div>
        </li>
       
      </ul>
    </div>
      </>
    )
  }
    )}
  
  </Card>
  )
}
