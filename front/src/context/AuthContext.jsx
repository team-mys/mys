//import { createContext, useContext, useState, useEffect } from 'react';
//import axios from 'axios';
//
//const AuthContext = createContext();
//
//export function AuthProvider({ children }) {
//  const [user, setUser] = useState(null);
//
//  // 앱 로드 시 localStorage에서 유저 정보를 복원
//  useEffect(() => {
//    const storedUser = localStorage.getItem('userResponseDto');
//    if (storedUser) {
//      setUser(JSON.parse(storedUser)); // 복원 시 userResponseDto만 저장
//    }
//  }, []);
//
//  const signup = async (userData) => {
//    try {
//      const response = await axios.post(
//        'http://59.24.237.51:8080/api/v1/user',
//        userData,
//        {
//          headers: {
//            'Content-Type': 'application/json',
//            'Accept': '*/*'
//          }
//        }
//      );
//      const userInfo = response.data.userResponseDto; // userResponseDto 저장
//      setUser(userInfo);
//      localStorage.setItem('accessToken', response.data.accessToken);
//      localStorage.setItem('userResponseDto', JSON.stringify(userInfo));
//    } catch (error) {
//      console.error("회원가입 실패", error);
//    }
//  };
//
//  const login = async (userData) => {
//    try {
//      const response = await axios.post(
//        "http://59.24.237.51:8080/api/v1/user/login",
//        userData,
//        {
//          headers: {
//            'Content-Type': 'application/json',
//            'Accept': '*/*'
//          },
//          withCredentials: false,
//        }
//      );
//
//      const userInfo = response.data.userResponseDto; // userResponseDto만 저장
//      setUser(userInfo);
//      localStorage.setItem('accessToken', response.data.accessToken);
//      localStorage.setItem('userResponseDto', JSON.stringify(userInfo));
//    } catch (error) {
//      console.error("로그인 실패", error);
//    }
//  };
//
//  const logout = () => {
//    setUser(null);
//    localStorage.removeItem('accessToken');
//    localStorage.removeItem('userResponseDto');
//  };
//
//  return (
//    <AuthContext.Provider value={{ user, logout, signup, login }}>
//      {children}
//    </AuthContext.Provider>
//  );
//}
//
//export function useAuth() {
//  return useContext(AuthContext);
//}

import { createContext, useContext, useState, useEffect } from 'react';
import axios from 'axios';

const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storedUser = localStorage.getItem('userResponseDto');
    if (storedUser && storedUser !== 'undefined') {
      try {
        setUser(JSON.parse(storedUser));
      } catch (error) {
        console.error('JSON 파싱 에러:', error);
        localStorage.removeItem('userResponseDto');
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
          withCredentials: false,
        }
      );

      const userInfo = response.data.userResponseDto; // userResponseDto만 저장
      setUser(userInfo);
      localStorage.setItem('accessToken', response.data.accessToken);
      localStorage.setItem('userResponseDto', JSON.stringify(userInfo));
    } catch (error) {
      console.error("로그인 실패", error);
    }
  };

  const logout = () => {
    setUser(null);
    localStorage.removeItem('accessToken');
    localStorage.removeItem('userResponseDto');
  };

  return (
    <AuthContext.Provider value={{ user, logout, signup, login }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}