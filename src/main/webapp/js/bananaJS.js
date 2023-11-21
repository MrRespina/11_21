function isEmpty(input) {
	return (!input.value);
}

function atLeastLetter(input, len) {
	return (input.value.length < len);
}

function isNotNumber(input) {
	return isNaN(input.value);
}

function bananaRegCheck() {

	let trademark = document.bananaForm.b_trademark;
	let location = document.bananaForm.b_location;
	let bundle = document.bananaForm.b_bundle;
	let price = document.bananaForm.b_price;
	let introduce = document.bananaForm.b_introduce;

	if (isEmpty(trademark)) {
		alert('상표를 입력해주세요 !');
		trademark.value = "";
		trademark.focus();
		return false;
	} else if (isEmpty(location)) {
		alert('원산지를 입력해주세요 !');
		location.value = "";
		location.focus();
		return false;
	} else if (atLeastLetter(location, 2)) {
		alert('원산지는 2글자 이상 입력해주세요 !');
		location.value = "";
		location.focus();
		return false;
	} else if (isEmpty(bundle)) {
		alert('갯수를 입력해주세요 !');
		bundle.value = "";
		bundle.focus();
		return false;
	} else if (isNotNumber(bundle)) {
		alert('갯수는 숫자만 입력해주세요 !');
		bundle.value = "";
		bundle.focus();
		return false;
	} else if (isEmpty(price)) {
		alert('가격을 입력해주세요 !');
		price.value = "";
		price.focus();
		return false;
	} else if (isNotNumber(price)) {
		alert('가격은 숫자만 입력해주세요 !');
		price.value = "";
		price.focus();
		return false;
	} else if (isEmpty(introduce)) {
		alert('설명을 입력해주세요 !');
		introduce.value = "";
		introduce.focus();
		return false;
	} else if (atLeastLetter(introduce, 5)) {
		alert('설명은 5글자 이상 입력해주세요 !');
		introduce.value = "";
		introduce.focus();
		return false;
	}

}

function goBackBanana() {

	let t = confirm('돌아가기?');

	if (t) {
		location.href = "BananaController?";
	}

}

function goBananaDetail(loc) {
	location.href = "BananaDetailController?b_num=" + loc;
}

function deleteBanana(loc) {
	
	let t = confirm('삭제한 데이터는 되돌릴 수 없습니다.');
	
	if(t){
		location.href="BananaDeleteController?b_num=" + loc;
	}else{
		
	}

}

function SearchBanana(){
	
	let t = document.getElementById('searchTrademark');
	alert('찾는 것 : '+t.value);
	
	if(isEmpty(t)){
		alert('찾고자 하는 제품의 상표명을 입력해주세요!');
		introduce.value = "";
		introduce.focus();
		return false;
	}
	
	let b = encodeURI("BananaSearchController?b_trademark="+t.value);
	location.href=b;
	
}