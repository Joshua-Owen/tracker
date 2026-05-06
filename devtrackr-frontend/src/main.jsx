import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
import App from './App.jsx'

//MUST BE RAN AFTER BACKEND
//MUST BE IN THE "devtrackr-frontend" DIRECTORY BEFORE RUNNING npm run dev
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
