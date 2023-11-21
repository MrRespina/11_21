function appleRegCheck() {

	let location = document.appleForm.a_location;
	let price = document.appleForm.a_price;
	let introduce = document.appleForm.a_introduce;

	if (isEmpty(location)) {
		alert('지역을 입력해주세요!!!');
		location.value = "";
		location.focus();
		return false;
	} else if (isEmpty(price)) {
		alert('가격을 입력해주세요!!!');
		price.value = "";
		price.focus();
		return false;
	} else if(isNotNumber(price)){
		alert('가격은 숫자만 입력해주세요!!!');
		price.value = "";
		price.focus();
		return false;
	} else if (isEmpty(introduce)) {
		alert('설명을 입력해주세요!!!');
		introduce.value = "";
		introduce.focus();
		return false;
	} else if(atLeastLetter(introduce,5)){
		alert('설명은 5자 이상으로 입력해주세요!!!');
		introduce.value = "";
		introduce.focus();
		return false;
	}

}
