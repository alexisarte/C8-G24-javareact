import locationVector from '../assets/vectors/locationVector.svg'

const Location = () =>{
    return(
        <button className='flex flex-row items-center gap-3 font-fontGafata max-lg:mr-4 hover:bg-yellow-200 rounded p-3'>
            <p>¿EN QUE REGION TE ENCUENTRAS?</p>
            <img src={locationVector} className="w-8"></img>
        </button>
    )
}

export default Location