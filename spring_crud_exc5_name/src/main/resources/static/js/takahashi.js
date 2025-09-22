window.addEventListener('DOMContentLoaded',function(){
	
	let btn_passview = document.getElementById("btn_passview");
	let input_pass = document.getElementById("input_pass");
	
	btn_passview.addEventListener("click",(e)=>{
		e.preventDefault();
		
		if(input_pass.type === 'password'){
			
			input_pass.type = 'text';
			btn_passview.textContent = 'パスワード非表示';
			
		}else{
			
			input_pass.type = 'password';
			btn_passview.textContent = 'パスワード表示';
		}
	});
	
	
	
});