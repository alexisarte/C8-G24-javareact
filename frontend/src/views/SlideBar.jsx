import { Slide } from "./Slide"

export const SlideBar = () => {
    const slides = [
        { descuento: '50%', titulo1: 'APROVECHA NUESTRO', titulo2: 'BLACK FRIDAY', titulo3: '¡¡OFERTAS IMPERDIBLES!!', url: '../src/assets/sonriendo1-ok.png', bg: '#F7D3F3' },
        { descuento: '25%', titulo1: 'En accesorios para', titulo2: '¡TU MASCOTA!', titulo3: 'Nuestros pequeños amigos', url: '../src/assets/cat.png', bg: '#90A8FF' }
    ]

    return (
        <Slide slides={slides} />
    )
}
