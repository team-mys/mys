import {createContext, useContext, useEffect, useState} from 'react';
import axios from 'axios';

const AuthContext = createContext();

export function AuthProvider({children}) {
  const [user, setUser] = useState(null);
  const [countdown, setCountdown] = useState(0);

  useEffect(() => {
    const storedUser = localStorage.getItem('userResponseDto');
    const storedCountdown = localStorage.getItem('countdown');
    if (storedUser && storedUser !== 'undefined') {
      try {
        setUser(JSON.parse(storedUser));
        if (storedCountdown) {
          const remainingTime = parseInt(storedCountdown, 10);
          startCountdown(remainingTime);
        }
      } catch (error) {
        console.error('JSON 파싱 에러:', error);
        localStorage.removeItem('userResponseDto');
        localStorage.removeItem('countdown');
      }
    }
  }, []);

  const signup = async (userData) => {
    try {
      const response = await axios.post(
        'http://59.24.237.51:8080/api/v1/user',
        userData,
        {
          headers: {
            'Content-Type': 'application/json',
            'Accept': '*/*'
          }
        }
      );
      const userInfo = response.data.userResponseDto; // userResponseDto 저장
      setUser(userInfo);
      localStorage.setItem('accessToken', response.data.accessToken);
      localStorage.setItem('userResponseDto', JSON.stringify(userInfo));
    } catch (error) {
      console.error("회원가입 실패", error);
    }
  };
  const login = async (userData) => {
    try {
      const response = await axios.post(
        "http://59.24.237.51:8080/api/v1/user/login",
        userData,
        {
          headers: {
            'Content-Type': 'application/json',
            'Accept': '*/*'
          },
          withCredentials: false
        }
      );
      console.log('서버 응답:', response.data);
      const userInfo = response.data.userResponseDto;
      setUser(userInfo);
      localStorage.setItem('accessToken', response.data.accessToken);
      localStorage.setItem('userResponseDto', JSON.stringify(userInfo));
      startCountdown(600);
    } catch (error) {
      if (error.response) {
        console.error("응답 오류:", error.response.data);
      } else if (error.request) {
        console.error("요청 오류:", error.request);
      } else {
        console.error("설정 오류:", error.message);
      }
      console.error("전체 오류 정보:", error.config);
    }
  };

  const startCountdown = (seconds) => {
    setCountdown(seconds);
    localStorage.setItem('countdown', seconds);
    const interval = setInterval(() => {
      setCountdown((prev) => {
        if (prev <= 1) {
          clearInterval(interval);
          logout();
          return 0;
        }
        const newCountdown = prev - 1;
        localStorage.setItem('countdown', newCountdown);
        return newCountdown;
      });
    }, 1000);
  };

  const logout = () => {
    setUser(null);
    localStorage.removeItem('accessToken');
    localStorage.removeItem('userResponseDto');
  };

  return (
    <AuthContext.Provider value={{user, logout, signup, login, countdown}}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}