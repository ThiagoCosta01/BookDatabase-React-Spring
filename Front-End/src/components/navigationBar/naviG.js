import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle';
import './naviG.css';

const navBar = () => {
    return ( 
        <nav className=' navBar'>
            <div className='buttonsBox'>
                <div className='menuBtnBox'>
                    <button className='btn btn-warning menuBtnBox-Button'>Menu</button>
                </div>
                <div className='myBooksBtnBox'>
                    <button className='btn btn-info myBooksBtnBox-Button'>Meus Livros</button>
                </div>
            </div>  
            <div className='searchBox'>
                <input type='text' className='searchBox-input ' placeholder='search'></input>
            </div>
            <div className='registerBox'>
                <span className='registerBox-register'><button>Cadastre-se  </button>| </span>
                <span className='registerBox-login'><button>Login</button></span>
            </div>
            <div className='aboutBtnBox'>
                <button className='btn btn-warning aboutBtnBox-button '>?</button>
            </div>
        </nav>
    );
}

export default navBar;