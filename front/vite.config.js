import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite';

export default defineConfig({
    plugins: [
      tailwindcss(),
      react()
    ],
    server: {
      // Proxy 설정
      proxy: {
        // 경로가 "/api" 로 시작하는 요청을 대상으로 proxy 설정
        '/api': {
          // 요청 전달 대상 서버 주소 설정
          target: 'http://59.24.237.51:8080',
          // 요청 헤더 host 필드 값을 대상 서버의 호스트 이름으로  변경
          changeOrigin: true,
          // SSL 인증서 검증 무시
          secure: false
        }
      }
    }
  }
);