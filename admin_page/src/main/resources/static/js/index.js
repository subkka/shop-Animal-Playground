const checkLoginStatus = function() {
    // 서버로부터 로그인 상태를 확인하는 요청을 보냄
    // fetch('/auth/check-login-status')
    //     .then(response => response.json())
    //     .then(data => {
    //         if (!data.loggedIn) {
    //             // 로그인 상태가 아닌 경우 로그인 페이지로 리디렉션
    //             window.location.href = '/login';
    //         }
    //     })
    //     .catch(error => console.error('Error:', error));
};

window.addEventListener('load', checkLoginStatus);