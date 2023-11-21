/**
 * 
 */

 function goAppleDetail(loc){
	location.href="AppleDetailController?a_location=" + loc;	
}

function deleteApple(loc){
	
	let t = confirm('삭제한 데이터는 되돌릴 수 없습니다.');
	
	if(t){
		location.href="AppleDeleteController?a_location=" + loc;
	}else{
		
	}
	
	
}

function goBackApple(){
	
	let t = confirm('돌아가기?');
	
	if(t){
		location.href="AppleController?";
	}
	
}