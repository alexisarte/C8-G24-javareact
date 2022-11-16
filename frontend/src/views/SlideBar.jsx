
export const SlideBar = () => {
    return (
        <div className="flex bg-red-100">

            <span className="flex-1 flex flex-col justify-center items-center h-96 text-9xl">
                50%
            </span>

            <div className="flex-1">

                <div className="flex flex-col justify-center items-center h-96">

                    <span className="text-3xl">APROVECHA NUESTRO</span>

                    <p className="text-6xl py-8">BLACK FRIDAY</p>

                    <span className="text-3xl">¡OFERTAS IMPERDIBLES!</span>

                </div>

            </div>

            <div className="flex-1">
                <img className="h-full" src="../src/assets/dogSmile.png" alt="" />
            </div>

        </div>
    )
}
